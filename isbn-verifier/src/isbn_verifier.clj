(ns isbn-verifier)

(defn isbn? [isbn]
  (= 0
     (some->> isbn
              (re-find
               #"^(\d)-?(\d{3})-?(\d{5})-?(\d|X)$")
              (rest)
              (apply str)
              (map #(if (= \X %)
                      10
                      (Character/digit % 10)))
              (map * (range 10 0 -1))
              (apply +)
              (#(mod % 11)))))
