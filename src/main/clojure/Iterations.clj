(ns Iterations)

(if "hi" \t)
;= \t
(if 42 \t)
;= \t
(if nil "unevaluated" \f)
;= \f
(if false "unevaluated" \f)
;= \f
(if (not true) \t)
;= nil as there is no else statement

; not related to if statement
(true? "string")
;= false

(def loopExample
  (loop [x 5]
    (println x)
    (if (neg? x)
      x
      (recur (dec x)))))