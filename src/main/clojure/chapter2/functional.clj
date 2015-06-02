(ns chapter2.functional)

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

(def writer (java.io.StringWriter.))

(def retained-logger (print-logger writer))