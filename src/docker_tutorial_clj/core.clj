(ns docker-tutorial-clj.core
  (:require [cheshire.core :refer :all])
  (:gen-class))

(defn -main
  [& args]
  (println (generate-string {:hello "world"})))
