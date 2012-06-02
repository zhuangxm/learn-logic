(ns c2-1
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic]
        [clojure.core.logic.dcg]))

;;http://www.csupomona.edu/~jrfisher/www/prolog_tutorial/2_1.html

(defrel adjacent R1 R2)

(facts adjacent [[1 2] [2 1] [1 3] [3 1] [1 4] [4 1]
                 [1 5] [5 1] [2 3] [3 2] [2 4] [4 2]
                 [3 4] [4 3] [4 5] [5 4]])

(defrel color R1 C Tag)

(facts color [[1 :red :a] [2 :blue :a] [3 :green :a]
              [4 :yellow :a] [5 :blue :a]
              [1 :red :b] [2 :blue :b] [3 :green :b]
              [4 :blue :b] [5 :green :b]])

(defn conflict
  ([tag]
     (fresh [x y c]
         (adjacent x y)
         (color x c tag)
         (color y c tag)))
  ([x y tag]
      (fresh [c]
             (adjacent x y)
             (color x c tag)
             (color y c tag))))

