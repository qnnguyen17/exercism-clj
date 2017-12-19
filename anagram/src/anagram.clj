(ns anagram
  (:require [clojure.string :as str]))

(defn- is-anagram
  [w1 w2]
  (and (not= w1 w2)
       (= (frequencies w1) (frequencies w2))))

(defn anagrams-for
  [word candidates]
  (filter #(is-anagram word %) candidates))
