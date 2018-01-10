require "json"

json = File.read(File.join(__dir__, "package.json"))
package = JSON.parse(json).deep_symbolize_keys

Pod::Spec.new do |s|
  s.name = package[:name]
  s.version = package[:version]
  s.license = package[:license]
  s.homepage = package[:homepage]
  s.authors = package[:author]
  s.summary = package[:description]
  s.source = { git: package[:repository][:url] }
  s.source_files = "ios/*"
  s.platform = :ios, "7.0"
end
