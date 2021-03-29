# Contributing
## EOL
Always set your editor to save line endings as `\n` instead of `\r\n`.  If you see `^M` characters at the end of the line, then you've got carriage returns.  See the following for more information:

- [What is ^M?](https://unix.stackexchange.com/questions/32001/what-is-m-and-how-do-i-get-rid-of-it#:~:text=156,marked%20by%20a%20single%20newline.)
- [Newline](https://en.wikipedia.org/wiki/Newline)

This will cause problems running with a shebang because `#!/usr/bin/env racket^M` will be run with as `racket\r`.

If you are using VS Code, change Settings -> Files:EoL to be `\n` only.
