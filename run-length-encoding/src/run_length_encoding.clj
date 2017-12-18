(ns run-length-encoding)

(def encode-transducer
  (comp
   (partition-by identity)
   (map (juxt count first))
   (map #(if (= 1 (first %))
           [(second %)]
           %))
   (map (partial apply str))))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  (transduce encode-transducer str s))

(defn decode-form
  [[_ num-str letter-str]]
  (repeat
   ((fnil #(Integer/parseInt %) "1") num-str)
   letter-str))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (->> (re-seq #"(\d+)?([A-Za-z]|\s)" s)
       (mapcat decode-form)
       (apply str)))
