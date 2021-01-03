val dottyVersion = "3.0.0-M3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "sisp-dotty",
    version := "0.2.0",

    scalaVersion := dottyVersion,

    libraryDependencies += "io.github.marchliu" % "jaskell-dotty_3.0.0-M3" % "0.2.3",
    libraryDependencies += "org.scalatest" % "scalatest_3.0.0-M3" % "3.2.3",
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
  )
