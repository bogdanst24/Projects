//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System.ComponentModel.DataAnnotations;
using System;

namespace Evenimente
{
    public partial class Comment
    {
        [Key]
        public int Id { get; set; }

        public string Description { get; set; }
        public string Date { get; set; }
        public Nullable<int> EventId { get; set; }
        public Nullable<int> UserId { get; set; }
    }
}