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
  (let [stripped (str/trim s)
        last-chr (nth stripped (dec (count stripped)) nil)]
    (cond
      (all-caps stripped) "Whoa, chill out!"
      (= \? last-chr) "Sure."
      (= "" stripped) "Fine. Be that way!"
      :else "Whatever.")))
