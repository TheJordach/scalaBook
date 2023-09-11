package challenge.leetcode
/*Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
  Example 1:
  Input: nums = [1,2,3,4,5,6,7], k = 3
  Output: [5,6,7,1,2,3,4]
  Explanation:
  rotate 1 steps to the right: [7,1,2,3,4,5,6]
  rotate 2 steps to the right: [6,7,1,2,3,4,5]
  rotate 3 steps to the right: [5,6,7,1,2,3,4]
  Example 2:

  Input: nums = [-1,-100,3,99], k = 2
  Output: [3,99,-1,-100]
  Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
  rotate 2 steps to the right: [3,99,-1,-100]

  Constraints:
  1 <= nums.length <= 105
  -231 <= nums[i] <= 231 - 1
  0 <= k <= 105

  Follow up: Try to come up with as many solutions as you can.
  There are at least three different ways to solve this problem.
  Could you do it in-place with O(1) extra space?

 */




class RotateArrayChallenge189 {


  /*******
   *  This function takes an array of Int , and an integer K, where k > 0.
   *  The function's responsibility is to rotate the array to the right by k steps.
   *  Time complexity is 0(n) where n is the size of the array.
   *
   *  The function handle three scenario of inputs base on the length of input array
   *  with respect to the value of k.
   *
   * This challenge comes from https://leetcode.com/ - Challenge: 189.Rotate Array
   *
   * @param nums
   * @param k
   */
  def rotate(nums: Array[Int], k: Int): Unit ={

   def performRotation(nums: Array[Int], k: Int): Unit = {
     val rotatedArray = nums.takeRight(k) ++ nums.take(nums.length - k)
     for (i <- nums.indices) {
       nums(i) = rotatedArray(i)
     }
   }


    if (nums.length > k) {
      performRotation(nums, k)
    }
    else if (nums.length == 2 && k > 2) {
      val temp = nums(0)
      nums(0) = nums(1)
      nums(1) = temp
    }
    else if (nums.length < k) {
      performRotation(nums, k - nums.length)
    }

    //end
}



//---------------------DRAFT ----------------------------------------------
  def draftSolution(nums: Array[Int], k: Int): Unit= {

    def performRotation(nums: Array[Int], k: Int): Unit = {
      val prefix = nums.takeRight(k)
      val suffix = nums.take(nums.length - k)
      val rotatedArray = prefix ++ suffix

      for (i <- nums.indices) {
        nums(i) = rotatedArray(i)
      }

      println(
        s"""
           |Input :${nums.mkString(", ")}
           |prefix :${prefix.mkString(", ")}
           |suffix :${suffix.mkString(", ")}
           |rotate :${rotatedArray.mkString(", ")}
           |Output :${nums.mkString(", ")}
           |""".stripMargin)

    }

    def performSwap(nums: Array[Int]): Unit = {
      val temp = nums(0)
      nums(0) = nums(1)
      nums(1) = temp
      println(nums.mkString(","))
    }

    if (nums.length > k) {
      performRotation(nums, k)
    }
    else if (nums.length == 2 && k > 2) {
        performSwap(nums)
    }
    else if (nums.length < k ){
      performRotation(nums, k- nums.length)
    }


  }




}
