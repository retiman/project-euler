(require srfi/41)
(require "lib/core.rkt")

(define charmap
  (zipmap
    (map integer->char (range (char->integer #\A) (add1 (char->integer #\Z))))
    (range 1 (add1 26))))

(define words
  ((compose (curryr string-split ",")
            (curryr string-replace "\"" ""))
     (file->string "../data/42.txt")))

(define (word-score w)
  ((compose (curry apply +)
            (curry map (curry hash-ref charmap))
            string->list)
     w))

(define longest-word-length
  (apply max (map string-length words)))

(define largest-word-score
  (* longest-word-length 26))

(define (triangle n)
  (quotient (* n (add1 n)) 2))

(define naturals
  (stream-cons 0 (stream-map add1 naturals)))

(define triangles
  (stream-map triangle naturals))

(define triangle-word-scores
  ((compose list->set
            stream->list
            (curry stream-take-while (curryr <= largest-word-score)))
     triangles))

(define (triangle? n)
  (set-member? triangle-word-scores n))

(displayln
  (length (filter triangle? (map word-score words))))
