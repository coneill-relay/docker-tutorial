(ns docker-tutorial-clj.core
  (:require [cheshire.core :refer :all]
            [taoensso.carmine :as car :refer (wcar)])
  (:gen-class))

(def host (or (. System (getenv "REDIS_HOST")) "localhost"))
(println host)

(def server1-conn {:pool {} :spec {:uri (str "redis://" host ":6379/")}})
(defmacro wcar* [& body] `(car/wcar server1-conn ~@body))

(defn -main
  [& args]
  (println "Response from redis" (wcar* (car/get "foo")))
  (println (generate-string {:hello "world"})))
