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

 (def mapRetain
   (let [{r1 :x r2 :y :as randoms}
         (zipmap [:x :y :z] (repeatedly (partial rand-int 10)))]
     (assoc randoms :sum (+ r1 r2))))

 (def mapDefualts
   (let [{k :unknown x :a
          :or {k 50}} m]
     (+ k x)))

 (def mapDefaults2
   (let [{k :unknown x :a} m
         k (or k 50)]
     (+ k x)))

 (def mapDefaults3
   (let [{opt1 :option} {:option false}
         opt1 (or opt1 true)
         {opt2 :option :or {opt2 true}} {:option false}]
     {:opt1 opt1 :opt2 opt2}))

(def chas {:name "Chas" :age 31 :location "Massachusetts"})

 (def chasBinding
   (let [{name :name age :age location :location} chas]
     (format "%s is %s years old and lives in %s." name age location)))

(def brian {"name" "Brian" "age" 31 "location" "British Columbia"})
(let [{:strs [name age location]} brian]
  (format "%s is %s years old and lives in %s." name age location))

(def christophe {'name "Christophe" 'age 33 'location "Rhône-Alpes"})
(let [{:syms [name age location]} christophe]
  (format "%s is %s years old and lives in %s." name age location))

(def user-info ["robert8990" 2011 :name "Bob" :city "Boston"])
(let [[username account-year & extra-info] user-info
      {:keys [name city]} (apply hash-map extra-info)]
  (format "%s is in %s" name city))
;= "Bob is in Boston"

(let [[username account-year & {:keys [name city]}] user-info]
  (format "%s is in %s" name city))
;= "Bob is in Boston"