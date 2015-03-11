(displayln
  ((compose list->string
            (curryr take 10)
            string->list
            number->string
            (curry apply +))
  (file->list "../data/13.txt")))
