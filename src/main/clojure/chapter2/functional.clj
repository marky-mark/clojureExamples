(ns chapter2.functional
  (:require [clojure.java.io :refer :all]
            [clojure.xml :refer :all]))

(defn call-twice [f x]
  (f x)
  (f x))

(defn adder
  [n]
  (fn [x] (+ n x)))

(defn doubler
  [f]
  (fn [& args]
    (* 2 (apply f args))))

(def double-+ (doubler +))

(defn print-logger
  [writer]
  #(binding [*out* writer]
    (println %)))

;*out* is A java.io.Writer object representing standard output for print operations.
;Defaults to System/out, wrapped in an OutputStreamWriter
(def *out*-logger (print-logger *out*))

(def string-writer (java.io.StringWriter.))

(def retained-logger (print-logger string-writer))

(defn file-logger
  [file]
  #(with-open [f (clojure.java.io/writer file :append true)]
    ((print-logger f) %)))

(def log->file (file-logger "build/messages.log"))

(defn multi-logger
  [& logger-fns]
  #(doseq [f logger-fns]
    (f %)))

(def log (multi-logger
           (print-logger *out*)
           (file-logger "build/messages.log")))

(defn timestamped-logger
  [logger]
  #(logger (format "[%1$tY-%1$tm-%1$te %1$tH:%1$tM:%1$tS] %2$s" (java.util.Date.) %)))

(def log-timestamped (timestamped-logger
                       (multi-logger
                         (print-logger *out*)
                         (file-logger "build/messages.log"))))

(defn twitter-followers
  [username]
  ;->> threads the expression. Inserts x as last item in form
  (->> (str "https://api.twitter.com/1/users/show.xml?screen_name=" username)
       clojure.xml/parse
       :content
       (filter (comp #{:followers_count} :tag))
       first
       :content
       first
       Integer/parseInt))

;prime only divisable by 1 or iteslf
(defn prime?
  [n]
  (cond
    (== 1 n) false
    (== 2 n) true
    (even? n) false
    ;range [start (3) end (square root of n + 1) step (2)]
    :else (->> (range 3 (inc (Math/sqrt n)) 2)
               ;remainder of each value in range above is zero then prime
               (filter #(zero? (rem n %)))
               ;empty? therefore only divisible by 1 or iteslf and so prime
               empty?)
    ))