//
//  RNBackgroundFileUploadHandler.m
//  VydiaRNFileUploader
//
//  Created by Justin Makaila on 11/20/20.
//  Copyright © 2020 Marc Shilling. All rights reserved.
//

#import "RNBackgroundMultipartRequestHandler.h"
#import <React/RCTNetworking.h>

@interface RCTBackgroundMultipartRequestHandler () <NSURLSessionDataDelegate>
@end

@implementation RCTHTTPRequestHandler


RCT_EXPORT_MODULE()

- (BOOL)canHandleRequest:(NSURLRequest *)request {
    return false;
}

- (id)sendRequest:(NSURLRequest *)request
     withDelegate:(id<RCTURLRequestDelegate>)delegate {
    return false
}


@end
