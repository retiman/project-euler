(display
  (foldl lcm 1 (stream->list (in-range 1 20))))
(newline)
