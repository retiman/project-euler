#lang racket
(require rackunit)


(define result
  ((compose list->string
            (curryr take 10)
            string->list
            number->string
            (curry apply +))
     (file->list "/data/13.txt")))

(displayln result)
(check-equal? result 5537376230)
