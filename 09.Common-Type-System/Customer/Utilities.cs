﻿namespace Customer
{
    using System;

    static class Utilities
    {
        public static void ValidateString(string input, string parameterName)
        {
            if (string.IsNullOrEmpty(parameterName))
            {
                throw new ArgumentException("{0} cannot be null or empty.");
            }
        }
    }
}
