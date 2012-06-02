(ns c2-3
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic]
        [clojure.core.logic.dcg])
  (:require [clojure.core.logic.arithmetic :as a]))

(defne move [n x y z]
  ([1 x y z] (project [x y z] (do  (prn "move from " x " to " y)
                                   succeed)))
  ([_ _ _ _] (project [n]
                      (a/> n 1)
                      (move (dec n) x z y)
                      (move 1 x y z)
                      (move (dec n) z y x))))
