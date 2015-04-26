/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var hash = {};
    for(var i=0; i<nums.length; i++) {
        hash[nums[i]] = i;
    }
    
    for(var i=0; i<nums.length; i++) {
        var needValue = target - nums[i];
        if(hash.hasOwnProperty(needValue)) {
            var index1 = i+1;
            var index2 = hash[needValue]+1;
            if(index1!==index2) {
                return [index1, index2];
            }
        }
    }
};
