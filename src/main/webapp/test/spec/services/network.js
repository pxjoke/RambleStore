'use strict';

describe('Service: Network', function () {

  // load the service's module
  beforeEach(module('rambleApp'));

  // instantiate service
  var Network;
  beforeEach(inject(function (_Network_) {
    Network = _Network_;
  }));

  it('should do something', function () {
    expect(!!Network).toBe(true);
  });

});
