(ns rna-transcription
  (:require [clojure.string :as str]))

(defn convert-base
  [b]
  (case b
    \G \C
    \C \G
    \T \A
    \A \U
    (throw (AssertionError. (str "Invalid base: " b)))))

(defn to-rna
  [dna]
  (->> dna
       (map convert-base)
       (str/join)))
