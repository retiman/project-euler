(ns lib.core
  (:refer-clojure :exclude
    (bit-and bit-or bit-not bit-xor bit-shift-right bit-shift-left))
  (:import
    [clojure.lang BigInt]
    [java.math BigInteger])
  (:require
    [clojure.string :as s]))

(declare 
  abs
  bigint?
  bit-and
  bit-not
  bit-or
  bit-shift-left
  bit-shift-right
  bit-xor
  ceil
  expt
  isqrt
  lg
  ln
  log
  parse-double
  parse-int
  parse-long
  round
  sqrt)

; The performance hit is not as much of a concern to me as getting the correct
; result.  The regular + and * functions do not support arbitrary precision,
; which is quite annoying for our purposes.
;
; As one can tell though, conversions between Integer/BigInt/BigInteger are
; extremely annoying in Clojure, which makes it the inferior "Lisp" for doing
; these types of problems :(
;
; See https://clojuredocs.org/clojure.core/+'
(doseq [sym ['+ '* 'inc 'dec]]
  (ns-unmap 'lib.core sym))

(def + +')
(def * *')
(def abs #(Math/abs %))
(def ceil #(Math/ceil %))
(def dec dec')
(def inc inc')
(def ln #(Math/log %))
(def round #(Math/round %))
(def sqrt #(Math/sqrt %))

(defn- bigint?
  [n]
  (or (instance? BigInt n)
      (instance? BigInteger n)))

(defn bit-and
  [a b]
  (if (or (bigint? a) (bigint? b))
    (let [a' (biginteger a)
          b' (biginteger b)]
      (.and ^BigInteger a' b'))
      (clojure.core/bit-and a b)))

(defn bit-not
  [a]
  (if (bigint? a)
    (-> ^BigInt a (.toBigInteger) (.not))
    (clojure.core/bit-not a)))

(defn bit-or
  [a b]
  (if (or (bigint? a) (bigint? b))
    (let [a' (biginteger a)
          b' (biginteger b)]
      (.or ^BigInteger a' b'))
      (clojure.core/bit-or a b)))

(defn bit-shift-left
  [a b]
  (if (bigint? a)
    (.shiftLeft ^BigInteger (biginteger a) b)
    (clojure.core/bit-shift-left a b)))

(defn bit-shift-right
  [a b]
  (if (bigint? a)
    (.shiftRight ^BigInteger (biginteger a) b)
    (clojure.core/bit-shift-right a b)))

(defn bit-xor
  [a b]
  (if (or (bigint? a) (bigint? b))
    (let [a' (biginteger a)
          b' (biginteger b)]
      (.xor ^BigInteger a' b'))
      (clojure.core/bit-xor a b)))

(defn expt
  [a b]
  (Math/pow a b))

(defn isqrt
  [n]
  (Math/floor (Math/sqrt n)))

(defn lg
  [n]
  (log 2 n))

(defn log
  [b n]
  (/ (ln n) (ln b)))

(defn parse-double
  [s]
  (Double/parseDouble (str s)))

(defn parse-int
  [s]
  (Integer/parseInt (str s)))

(defn parse-long
  [s]
  (Long/parseLong (str s)))
