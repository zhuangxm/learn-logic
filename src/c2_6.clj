(ns c2-6
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic]
        [clojure.core.logic.dcg])
  (:require [clojure.core.logic.arithmetic :as a]))

(defrel parent? Parent Child)

(facts parent? [[:a :b] [:a :c] [:a :d]
                [:b :e] [:b :f]
                [:c :g] [:c :h] [:c :i]
                [:d :j] [:e :k]
                [:f :l] [:f :m] [:h :n]
                [:i :o] [:i :p]
                [:j :q] [:j :r] [:j :s]
                [:m :t] ])

(defn siblings? [x y]
  (fresh [z]
         (parent? z x)
         (parent? z y)
         (!= x y)))

(defne same-level? [x y]
  ([_ _] (== x y))
  ([_ _]
     (fresh [w z]
            (parent? w x)
            (parent? z y)
            (same-level? w z))))

(defne has-depth [x d]
  ([:a 0] )
  ([_ _]
     (fresh [z d1]
            (parent? z x)
            (has-depth z d1)
            (project [d1]
                     (== d (inc d1))))))

(defne path [x]
  ([:a])
  ([_] (fresh [z]
              (parent? z x)
              (path z)
              (project [x z]
                       (do (pr z "-->") succeed)))))

(defn locate [x]
  (all 
   (path x)
   (do (pr x) succeed)))
