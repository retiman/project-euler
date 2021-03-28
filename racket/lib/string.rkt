#lang racket
(provide string-drop
         string-take)


; Returns s with the first n characters dropped.
(define (string-drop n s)
  (if (>= n (string-length s))
    ""
    ((compose list->string
              (curryr drop n)
              string->list) s)))

; Returns the first n characters of s.
(define (string-take n s)
  (if (>= n (string-length s))
    s
    ((compose list->string
              (curryr take n)
              string->list) s)))
