val dottyVersion = "3.0.0-M1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "sisp-dotty",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    libraryDependencies += "io.github.marchliu" % "jaskell-dotty_3.0.0-M1" % "0.1.1",
    libraryDependencies += "org.scalatest" % "scalatest_3.0.0-M1" % "3.2.3",
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
  )
