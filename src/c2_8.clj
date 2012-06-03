(ns c2-8
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic]
        [clojure.core.logic.dcg]
        [c2-7])
  (:require [clojure.core.logic.arithmetic :as a]))

(defne change [s]
  ([[h q d n p]]
     (member h [0 1 2])
     (member q [0 1 2 3 4])
     (member d [0 1 2 3 4 5 6 7 8 9 10])
     (member n [0 1 2 3 4 5 6 7 8 9 10
                11 12 13 14 15 16 17 18 19 20])
     (fresh [s]
            (project [h q d n]
                     (== s (+ (* 50 h)
                              (* 25 q)
                              (* 10 d)
                              (* 5 n)))
                     (project [s]
                              (a/<= s 100)
                              (== p (- 100 s)))))))
