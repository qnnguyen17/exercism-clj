(ns bob
  (:require [clojure.string :as str]))

(defn all-caps
  [string]
  (let [alphas (filter #(Character/isLetter %) string)]
    (and (pos? (count alphas))
         (reduce #(and %1 (Character/isUpperCase %2))
                 true
                 alphas))))

(defn response-for
  [s]
  (let [stripped (str/trim s)]
    (cond
      (all-caps stripped) "Whoa, chill out!"
      (str/ends-with? stripped "?") "Sure."
      (empty? stripped) "Fine. Be that way!"
      :else "Whatever.")))
