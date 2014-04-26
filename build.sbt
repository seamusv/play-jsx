sbtPlugin := true

name := "play-jsx"

organization := "com.github.hexx"

version := "0.0.3-SNAPSHOT"

scalaVersion := "2.10.4"

scalacOptions := Seq("-deprecation", "-unchecked")

resolvers += "Typesafe snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3-SNAPSHOT")

publishMavenStyle := true

publishArtifact in Test := false

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) 
    Some("snapshots" at nexus + "content/repositories/snapshots") 
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/hexx/play-jsx</url>
  <licenses>
    <license>
      <name>MIT License</name>
      <url>http://www.opensource.org/licenses/mit-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:hexx/play-jsx.git</url>
    <connection>scm:git:git@github.com:hexx/play-jsx.git</connection>
  </scm>
  <developers>
    <developer>
      <id>hexx</id>
      <name>Seitaro Yuuki</name>
      <url>https://github.com/hexx</url>
    </developer>
  </developers>)
