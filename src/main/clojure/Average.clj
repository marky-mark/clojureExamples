 (ns Average)

(defn average [numbers]
 (/ (apply + numbers) (count numbers)))

