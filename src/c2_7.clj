(ns c2-7
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic]
        [clojure.core.logic.dcg])
  (:require [clojure.core.logic.arithmetic :as a]))

(defne member [x s]
  ([_ [x . _]])
  ([_ [_ . r]] (member x r)))

(defne takeout [x s result]
  ([_ [x . r] r])
  ([_ [h . t] [h . r]] (takeout x t r)))

(defne subset [small-s big-s]
  ([[x . t] _] (member x big-s) (subset t big-s))
  ([[] _]))

(defna split [bs s1 s2]
  ([[] [] []])
  ([a a []])
  ([[a . [b . r]] [a . ra] [b . rb]]
     (split r ra rb)))

(defne perm [xs ys]
  ([[x . y] _]
     (fresh [w]
            (perm y w) (takeout x ys w)))
  ([[] []]))

(defne substract [bs s1 s2]
  ([_ [] bs])
   ([_ [h . t] _]
     (fresh [r]
            (takeout h bs r) (substract r t s2))))
