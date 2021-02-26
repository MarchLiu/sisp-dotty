val dottyVersion = "3.0.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "sisp-dotty",
    version := "0.2.0",

    scalaVersion := dottyVersion,

    libraryDependencies += "io.github.marchliu" % "jaskell-dotty_3.0.0-RC1" % "0.2.6",
    libraryDependencies += "org.scalatest" % "scalatest_3.0.0-RC1" % "3.2.4",
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
  )
