(ns chapter2.functional
  (:require [clojure.java.io :refer :all]))

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