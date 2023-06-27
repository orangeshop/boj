import Foundation

func solution(_ numbers:[Int]) -> Double {
    
    let avg = Double(numbers.reduce(0, +))
    
    print(avg/Double(numbers.count))
    
    return avg/Double(numbers.count)
}