 (ns SpecialForm)

(defn hypot
 [x y]
 (let [x2 (* x x)
       y2 (* y y)]
  (Math/sqrt (+ x2 y2))))

(def v [42 "foo" 99.2 [5 12]])

 (def foo
   (let [[x y z] v]
     (+ x z)))

 (def fooAgain
   (let [x (nth v 0)
         y (nth v 1)
         z (nth v 2)]
     (+ x z)))

 (def fooMore
   (let [[x _ _ [y z]] v]
     (+ x y z)))

 (def fooRest
   (let [[x & rest] v]
     rest))

 (def retain
   (let [[x _ z :as original-vector] v]
     (conj original-vector (+ x z))))

(def m {:a 5 :b 6
        :c [7 8 9]
        :d {:e 10 :f 11}
        "foo" 88
        42 false})

 (def mapDestruct
   (let [{a :a b :b} m]
     (+ a b)))

 (def mapFoo
   (let [{f "foo"} m]
     (+ f 12)))

 (def mapFoo2
   (let [{v 42} m]
     (if v 1 0)))

 (def map2D
   (let [{x 3 y 8} [12 0 0 -18 44 6 0 0 1]]
     (println "value of x" x)
     (println "value of y" y)
     (+ x y)))

 (def mapDestructAgain
   (let [{{e :e} :d} m]
     (* 2 e)))

 (def seqMap
   (let [{[x _ y] :c} m]
     (+ x y)))

(def map-in-vector ["James" {:birthday (java.util.Date. 73 1 6)}])

 (def resolveBirthday
   (let [[name {bd :birthday}] map-in-vector]
     (str name " was born on " bd)))