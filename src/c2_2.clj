(ns c2-2
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic]
        [clojure.core.logic.dcg])
  (:require [clojure.core.logic.arithmetic :as a]))

(defne factorial [x r]
  ([0 1])
  ([_ _]
     (fresh [r1]
            (project [x]
                     (a/> x 0)
                     (factorial (dec x) r1)
                     (project [r1]
                              (== r (* x r1)))))))

(defne factorial-3 [x c r]
  ([0 c r] (== c r))
  ([_ c r] (project [x c]
                    (a/> x 0)
                    (factorial-3 (dec x) (* x c) r)) ))
