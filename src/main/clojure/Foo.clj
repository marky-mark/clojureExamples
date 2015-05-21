 (ns Foo)

(defn average
 [numbers]
 (/ (apply + numbers) (count numbers)))
