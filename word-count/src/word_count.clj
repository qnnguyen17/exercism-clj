(ns word-count
  (:require [clojure.string :as str]))

(defn word-count
  [phrase]
  (->> (str/split phrase #"\W+")
       (map str/lower-case)
       (frequencies)))
