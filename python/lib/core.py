def compose(*funcs, **kfuncs):
  return reduce(lambda f, g: lambda *args, **kaargs: f(g(*args, **kaargs)), funcs)
