/**
 * @param {*} obj
 * @param {Function} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    // Edge case: obj is null/undefined, or classFunction isn't a function
    if (obj === null || obj === undefined || typeof classFunction !== 'function') {
        return false;
    }
    
    let proto = Object.getPrototypeOf(obj);
    
    while (proto !== null) {
        if (proto === classFunction.prototype) {
            return true;
        }
        proto = Object.getPrototypeOf(proto);
    }
    
    return false;
};
