 (ns Functions)

 (fn add10 [x]
  (+ 10 x))

(comment This is similar to (let [x 3
               y 4
               z 12]
          (+ x y z)) )
((fn [x y z] (+ x y z))
 3 4 12)

(comment The same as (defn strange-adder
                               ([x] (strange-adder x 1))
                               ([x y] (+ x y))))
(def strange-adder (fn adder-self-reference
                    ([x] (adder-self-reference x 1))
                    ([x y] (+ x y)))
 )

(defn concat-rest
 [x & rest]
 (apply str (butlast rest)))

(defn make-user
 [& [user-id]]
 {:user-id (or user-id
               (str (java.util.UUID/randomUUID)))})

(defn make-full-user
 [username & {:keys [email join-date]
              :or {join-date (java.util.Date.)}}]
 {:username username
  :join-date join-date
  :email email
  ;; 2.592e9 -> one month in ms
  :exp-date (java.util.Date. (long (+ 2.592e9 (.getTime join-date))))})