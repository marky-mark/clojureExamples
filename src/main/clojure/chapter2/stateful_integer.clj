(ns chapter2.stateful-integer
  (:import (chapter2 StatefulInteger)))

(def five
  (StatefulInteger. 5))
;= #'user/five
(def six
  (StatefulInteger. 6))

;= #'user/six
(.intValue five)
;= 5
(= five six)
;= false
(.setInt five 6)
;= nil
(= five six)
;= true
