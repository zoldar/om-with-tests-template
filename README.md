# om-with-tests

A Leiningen template for creating Om applications with a continuous testing setup.

## Usage

Start by creating a new Om project based on `om-with-tests` lein-template.

```bash
lein new om-with-tests om-tut
```

Then, in project's root directory, start coninuous build of development version of the application:

```bash
lein cljsbuild auto dev
```

In another terminal, run continuous testing:

```bash
lein cljsbuild auto test
```

Hooking up to project's REPL, in case of [LightTable][1], can be accomplished by adding external browser connection as described in [David Nolen's][2] [Tutorial on OM][3]

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[1]: http://www.lighttable.com/
[2]: https://github.com/swannodette
[3]: https://github.com/swannodette/om/wiki/Basic-Tutorial