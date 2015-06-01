(ns chapter2.functional)

(defn call-twice [f x]
  (f x)
  (f x))