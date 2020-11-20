/**
 *  RNBackgroundFileUploadHandler.h
 *  VydiaRNFileUploader
 *
 *  Created by Justin Makaila on 11/20/20.
 *  Copyright © 2020 Marc Shilling. All rights reserved.
 */

#import <React/RCTURLRequestHandler.h>

/**
 * This is the default RCTURLRequestHandler implementation for data URL requests.
 */
@interface RCTBackgroundMultipartRequestHandler : NSObject <RCTURLRequestHandler, RCTInvalidating>

@end

