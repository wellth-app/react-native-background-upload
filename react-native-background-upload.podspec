#
# Be sure to run `pod lib lint react-native-background-upload.podspec' to ensure this is a
# valid spec before submitting.
#
# Any lines starting with a # are optional, but their use is encouraged
# To learn more about a Podspec see https://guides.cocoapods.org/syntax/podspec.html
#

Pod::Spec.new do |s|
  s.name             = 'react-native-background-upload'
  s.version          = '4.5.0'
  s.summary          = 'Cross platform http post file uploader with android and iOS background support'

  s.homepage         = 'https://github.com/wellth-app/react-native-background-upload'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = 'Steve Potter'
  s.source           = { :git => 'https://github.com/wellth-app/react-native-background-upload.git', :tag => s.version.to_s }

  s.ios.deployment_target = '8.0'

  s.source_files = 'react-native-background-upload/Classes/**/*'
  
  s.source_files = 'ios/**/*.{h,m}'
  s.requires_arc = true

  s.dependency 'React'
end
