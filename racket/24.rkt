(define (list->number lst)
  ((compose string->number
            (curry apply string-append)
            (curry map number->string))
   lst))

(displayln
  ((compose (curryr vector-ref (sub1 1000000))
            list->vector
            (curryr sort <)
            (curry map list->number)
            permutations)
    (range 10)))
