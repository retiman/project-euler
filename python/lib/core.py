def compose(*funcs, **kfuncs):
    return reduce(lambda f, g: lambda *args, **kaargs: f(g(*args, **kaargs)), funcs)

def irange(start, end = None, step = None):
    if end == None:
        end = start
        return xrange(end + 1)
    elif start >= end:
        if step == None:
            step = -1
        return xrange(start, end - 1, step)
    else:
        if step == None:
            step = 1
        return xrange(start, end + 1, step)
