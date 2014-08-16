# om-with-tests

A Leiningen template for creating Om applications with a continuous testing setup.

## Requirements

[PhantomJS][1] is required in order to run tests.

## Usage

Start by creating a new Om project based on `om-with-tests` lein-template.

```bash
lein new om-with-tests om-tut
```

Then, in project's root directory, start coninuous build of development version of the application:

```bash
lein cljsbuild auto
```

In another terminal, run continuous testing:

```bash
lein with-profile -dev,+tdd cljsbuild auto
```

In order to generate release build with advanced optimizations enabled, issue this command:

```bash
lein with-profile -dev cljsbuild once
```

### Emacs

Open the generated `core.cljs` file in Emacs from the `src/cljs/om-tut` directory and run the `C-c M-j` shortcut (or `M-x cider-jack-in`).

The command needs sometime to download dependencies and plugins, to compile the ClojureScript code and to run the nREPL server and client. So, be patient the very first time.

Once the nREPL is ready, evaluate the following Clojure forms:

```clj
(run) ; to run the included http server
```

and then

```clj
(browser-repl) ; to run the Browser Connected REPL
```

Finally, visit the `http://localhost:3000` URL to activate the Browser Connected REPL.

Evaluate `core.cljs` file form by form starting from the namespace declaration. To do that just position your cursor at the end of each form and type `C-c C-e`.

## Acknowledgements

Template is based on [omchaya][2] example application, [om-start-template][3] and a couple of other tidbits of information from around the Internet. It's a very first release so I will be grateful for any feedback.

## License

Copyright © 2014 Adrian Gruntkowski

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[1]: http://phantomjs.org
[2]: https://github.com/sgrove/omchaya
[3]: https://github.com/magomimmo/om-start-template
