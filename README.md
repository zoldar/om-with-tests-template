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

Template is based on [omchaya][4] example application, [om-start-template][5] and a couple of other tidbits of information from around the Internet. It's a very first release so I will be greateful for any feedback.

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[1]: http://www.lighttable.com/
[2]: https://github.com/swannodette
[3]: https://github.com/swannodette/om/wiki/Basic-Tutorial
[4]: https://github.com/sgrove/omchaya
[5]: https://github.com/magomimmo/om-start-template
